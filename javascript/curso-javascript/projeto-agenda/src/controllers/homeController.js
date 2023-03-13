const Contact = require('../models/ContactsModel');

exports.index = async (req, res) => {
    const contacts = await Contact.findContacts();
    res.render('index', { contacts });
};

