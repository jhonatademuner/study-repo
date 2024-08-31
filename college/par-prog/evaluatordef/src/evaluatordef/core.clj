(ns evaluatordef.core
(:gen-class))

(require '[clojure.core.match :refer [match]])

(defrecord Env [parent defs])

(defn predef-env []
  (->Env nil {'inc inc
    'dec dec
    '+ (fn [x y] (+ x y))
    '- (fn [x y] (- x y))
    '* (fn [x y] (* x y))
    '/ (fn [x y] (/ x y))
    '> (fn [x y] (> x y))}))

(defn env-get
  [env name]
  (cond (contains? (:defs env) name) (get-in env [:defs name])
    (not (nil? (:parent env))) (env-get (:parent env) name)
    :else (throw
      (ex-info
      (format "Undefined symbol: %s." name)
      {:symbol name}))))

(declare avalia)
(defn avalia-do [forms env]
  (loop [current-form (first forms)
    current-env env
    rest-forms (rest forms)]
    (let [[new-env value] (avalia current-form current-env)]
      (if (empty? rest-forms)
        (avalia current-form new-env)
        (recur (first rest-forms) new-env (rest rest-forms))))))

(defn rator-rands-loop [rands env]
  (loop [rand rands
    current-env (first env)
    rand-vals []] 
    (if (empty? rand)
      [current-env rand-vals]
      (let [[new-env new-rand] (avalia (first rand) current-env)]
      (recur (rest rand) [new-env new-rand] (conj rand-vals new-rand))))))

(defn avalia
  ([x] (avalia x (predef-env)))
  ([x env]
    (match [x]
      [(n :guard number?)] [env n]
      [(t :guard string?)] [env t]
      [(b :guard boolean?)] [env b]
      [(v :guard symbol?)] [env (env-get env v)]
      [(['quote q] :seq)] [env q]
      [(['if test then else] :seq)]
      (let [[test-env test-val] (avalia test env)]
        (if test-val
          (avalia then test-env)
          (avalia else test-env)))

      [(['set! name value] :seq)]
      (let [[new-env value] (avalia value env)]
        [(assoc-in new-env [:defs name] value) value])

      [(['do & forms] :seq)] (avalia-do forms env)

      ;; Abstração
      [(['fun [formal-arg] body] :seq)]
      [env (fn [actual-arg]
        (avalia body
          (->Env env {formal-arg actual-arg})))]

      ;; Abstração com múltiplos argumentos
      [(['fun [& fargs] body] :seq)]
      [env (fn [& aargs]
        (if (= (count fargs) (count aargs))
          (avalia body (->Env env
            (into {} (map vector fargs aargs))))
          (throw
            (ex-info (format
              "Arity error. Expected: %d. Found: %d."
              (count fargs)
              (count aargs))
            {}))))]
      
      ;; Aplicação
      [([rator rand] :seq)]
      (let [[rator-env rator-val] (avalia rator env)]
        (if (fn? rator-val)
          (let [[rand-env rand-val] (avalia rand rator-env)]
            [rand-env (rator-val rand-val)])
          (throw (ex-info "Expected function but got something else"
                          {:rator rator-val :expr x}))))

      ;; Aplicação com múltiplos argumentos
      [([rator & rands] :seq)]
      (let [[rator-env rator-val] (avalia rator env)]
        (if (fn? rator-val)
          (let [[rator-env rand-vals] (rator-rands-loop rands rator-env)]
            [rator-env (apply rator-val rand-vals)])
          (throw (ex-info "Expected function but got something else"
            {:rator rator-val :expr x})))))))

