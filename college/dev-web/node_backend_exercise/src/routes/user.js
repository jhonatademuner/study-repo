const router = require("express-promise-router")();
const basicAuth = require("express-basic-auth");

const userController = require("../controllers/user");
const auth = require("../controllers/auth");

var challangeAuth = basicAuth({
  authorizer: auth.authenticate,
  authorizeAsync: true,
  unauthorizedResponse: {
    sucesso: 0,
    error: "usuario ou senha nao confere",
    cod_erro: 0,
  },
});

router.post("/registrar", userController.registerUser);

router.post("/login", challangeAuth, function (req, res) {
  res.status(200).send({ sucesso: 1 });
});

module.exports = router;
