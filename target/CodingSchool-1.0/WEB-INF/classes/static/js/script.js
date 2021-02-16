// JQuery is Love. JQuery is Life <3
$(document).ready(function() {

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    //
    /////   VALIDATION OF TRAINER FORM


    if ($('body').is('.trainer_form')) {
        const firstnameEl = document.querySelector('#tname');
        const lastnameEl = document.querySelector('#tlname');
        const dobEl = document.querySelector('#dob');
        const subjectEl = document.querySelector('#tsubject');


        const form = document.querySelector('#tform');

        const checkfirstname = () => {

            let valid = false;

            const min = 2,
                max = 25;

            const firstname = firstnameEl.value.trim();

            if (!isRequired(firstname)) {
                showError(firstnameEl, 'First name cannot be blank.');
            } else if (!isBetween(firstname.length, min, max)) {
                showError(firstnameEl, `First name must be between ${min} and ${max} characters.`)
            } else if (!isFirstNameValid(firstname)) {
                showError(firstnameEl, 'First name is not valid.')
            } else {
                showSuccess(firstnameEl);
                valid = true;
            }
            return valid;
        };

        const checklastname = () => {

            let valid = false;

            const min = 2,
                max = 25;

            const lastname = lastnameEl.value.trim();

            if (!isRequired(lastname)) {
                showError(lastnameEl, 'Last name cannot be blank.');
            } else if (!isBetween(lastname.length, min, max)) {
                showError(lastnameEl, `Last name must be between ${min} and ${max} characters.`)
            } else if (!isLastNameValid(lastname)) {
                showError(lastnameEl, 'Last name is not valid.')
            } else {
                showSuccess(lastnameEl);
                valid = true;
            }
            return valid;
        };


        const checkDob = () => {
            let valid = false;
            const dob = dobEl.value.trim();
            if (!isRequired(dob)) {
                showError(dobEl, 'Date of birth cannot be blank.');
            } else if (!isDobValid(dob)) {
                showError(dobEl, 'Date of birth is not valid.')
            } else {
                showSuccess(dobEl);
                valid = true;
            }
            return valid;
        };

        const checksubject = () => {

            let valid = false;

            const min = 2,
                max = 30;

            const subject = subjectEl.value.trim();

            if (!isRequired(subject)) {
                showError(subjectEl, 'Subject cannot be blank.');
            } else if (!isBetween(subject.length, min, max)) {
                showError(subjectEl, `Subject must be between ${min} and ${max} characters.`)
            } else if (!isSubjectValid(subject)) {
                showError(subjectEl, 'Subject is not valid.')
            } else {
                showSuccess(subjectEl);
                valid = true;
            }
            return valid;
        };



        const isRequired = value => value === '' ? false : true;
        const isBetween = (length, min, max) => length < min || length > max ? false : true;


        const showError = (input, message) => {
            // get the form-field element
            const formField = input.parentElement;
            // add the error class
            formField.classList.remove('success');
            formField.classList.add('error');

            // show the error message
            const error = formField.querySelector('small');
            error.textContent = message;
        };

        const showSuccess = (input) => {
            // get the form-field element
            const formField = input.parentElement;

            // remove the error class
            formField.classList.remove('error');
            formField.classList.add('success');

            // hide the error message
            const error = formField.querySelector('small');
            error.textContent = '';
        }

        const isFirstNameValid = (firstname) => {
            const re = /^[a-zA-Z]*$/;
            return re.test(firstname);
        }

        const isLastNameValid = (lastname) => {
            const re = /^[a-zA-Z]*$/;
            return re.test(lastname);
        }


        const isDobValid = (dob) => {
            const re = /^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$/;
            return re.test(dob);
        }

        const isSubjectValid = (subject) => {
            const re = /^[a-zA-Z#]+(,\s*[a-zA-Z#]+)*$/;
            return re.test(subject);
        };




        const debounce = (fn, delay = 500) => {
            let timeoutId;
            return (...args) => {
                // cancel the previous timer
                if (timeoutId) {
                    clearTimeout(timeoutId);
                }
                // setup a new timer
                timeoutId = setTimeout(() => {
                    fn.apply(null, args)
                }, delay);
            };
        };

        form.addEventListener('submit', function(e) {
            // prevent the form from submitting
            e.preventDefault();

            // validate fields
            let isfirstnameValid = checkfirstname(),
                isLastNameValid = checklastname(),
                isDoBvalid = checkDob(),
                isSubjectValid = checksubject();

            let isFormValid = isfirstnameValid &&
                isLastNameValid &&
                isDoBvalid &&
                isSubjectValid;

            // submit if the form is valid
            if (isFormValid) {
                alert("Trainer " + firstnameEl.value + " " + lastnameEl.value + " hired!");
                form.submit();
            }
        });

        form.addEventListener('input', debounce(function(e) {
            switch (e.target.id) {
                case 'tname':
                    checkfirstname();
                    break;
                case 'tlname':
                    checklastname();
                    break;
                case 'dob':
                    checkDob();
                    break;
                case 'tsubject':
                    checksubject();
            }
        }));
    };

});