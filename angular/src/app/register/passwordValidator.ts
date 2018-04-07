import {FormControl, FormGroup} from '@angular/forms';

export function passwordValidator (otherControlName: string) {

    // tslint:disable-next-line:no-shadowed-variable
    return function passwordValidator(g: FormControl) {
        return g.get('password').value === g.get('passwordRepeat').value
           ? null : {'mismatch': true};
    };
}
