function myFunction(){
    const taskInput = document.querySelector('.input-tarefa');
    const addBtn = document.querySelector('.add-btn');
    const taskList = document.querySelector('.lista-tarefas');

    function createListElement(content){
        const task = document.createElement('li');
        task.innerText = content;
        return task;
    }

    function createRemoveButton(){
        const removeBtn = document.createElement('button');
        removeBtn.innerText = 'Remover';
        removeBtn.classList.add('remove-btn');
        return removeBtn;
    }

    function createTask(content){
        const task = createListElement(content);
        task.appendChild(createRemoveButton())
        taskList.appendChild(task);
        clearInput();
        taskInput.focus();
        saveTasks();
    }

    function clearInput(){
        taskInput.value = '';
        taskInput.focus();
    }

    function saveTasks(){
        const tasks = taskList.querySelectorAll('li');
        const userTasks = [];
        for (let task of tasks){
            let text = task.innerText;
            text = text.replace('\nRemover', '');
            userTasks.push(text);
        }
        const savedTasks = JSON.stringify(userTasks);
        localStorage.setItem('savedTasks', savedTasks);
    }

    function loadTasks(){
        const savedTasks = localStorage.getItem('savedTasks');
        const taskList = JSON.parse(savedTasks);
        for (let task of taskList){
            createTask(task);
        }
    }

    addBtn.addEventListener('click', function(e){
        if (taskInput.value === ''){
            taskInput.focus();
            return;
        }
        createTask(taskInput.value);  
    })

    taskInput.addEventListener('keypress', function(e){
        if (e.keyCode == '13'){
            if (taskInput.value === ''){
                taskInput.focus();
                return;
            }
            createTask(taskInput.value);
        }
    })

    taskList.addEventListener('click', function(e){
        const clickTarget = e.target;
        if (clickTarget.classList.contains('remove-btn')){
            clickTarget.parentElement.remove();
            taskInput.focus();
            saveTasks();
        }
    })

    loadTasks();
}
myFunction();