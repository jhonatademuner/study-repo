const mongoose = require('mongoose');
const validator = require('validator');


const ContactSchema = new mongoose.Schema({
    name : {type: String, required: true},
    address : {type: String, required: false, default: ''},
    telephone : {type: String, required: false, default: ''},
    email : {type: String, required: false, default: ''},
    created_at : {type: Date, default: Date.now}
});

const ContactModel = mongoose.model('Contact', ContactSchema);

function Contact(body){
    this.body = body;
    this.errors = [];
    this.user = null;
};

Contact.prototype.register = async function(){
    this.validate();

    if(this.errors.length > 0) return;

    this.contact = await ContactModel.create(this.body);
};

Contact.prototype.validate = function(){
    this.cleanUp();

    if(this.body.email && !validator.isEmail(this.body.email)){
            this.errors.push('Invalid email address');
    };

    if(!this.body.name){
        this.errors.push('Name is required');
    };

    if(!this.body.email && !this.body.telephone){
        this.errors.push('Email or telephone is required');
    };
};


Contact.prototype.cleanUp = function(){
    for(const key in this.body){
        if(typeof this.body[key] !== 'string'){
            this.body[key] = '';
        };
    };
    
    this.body = {
        name: this.body.name,
        address: this.body.address,
        telephone: this.body.telephone,
        email: this.body.email,
    };
};

Contact.prototype.edit = async function(id){
    if(typeof id !== 'string') return;
    this.validate();
    if(this.errors.length > 0) return;
    this.contact = await ContactModel.findByIdAndUpdate(id, this.body, {new: true});
};

// Static methods
Contact.findById = async function(id){
    if(typeof id !== 'string') return;
    const user = await ContactModel.findById(id);
    return user;
};

Contact.findContacts = async function(){
    const contacts = await ContactModel.find()
        .sort({created_at: -1});
    return contacts;
};

Contact.delete = async function(id){
    if(typeof id !== 'string') return;
    const contact = await ContactModel.findOneAndDelete({_id: id});
    return contact;
};

module.exports = Contact;

