import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';

function comparePassword(c: AbstractControl) {
  const v = c.value;
  return (v.password === v.confirmPassword) ? null : {
    passwordnotmatch: true
  };
}

@Component({
  selector: 'app-register-full-test',
  templateUrl: './register-full-test.component.html',
  styleUrls: ['./register-full-test.component.scss']
})
export class RegisterFullTestComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
    this.registerForm = this.fb.group({
      name: ['', [Validators.required, Validators.pattern('[A-Za-z]+')]],
      birthday: ['', this.checkBirthDay],
      email: ['', [Validators.required, Validators.email]],
      pwGroup: this.fb.group({
        password: ['', [Validators.required, Validators.minLength(6)]],
        confirmPassword: ['', [Validators.required, Validators.minLength(6)]]
      }, {validator: comparePassword}),
      country: ['', Validators.required],
      age: ['', [Validators.required, Validators.min(18)]],
      gender: ['', Validators.required],
      phone: ['', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]]
    });

    // update form state
    this.registerForm.patchValue({
      email: 'info@example.com'
    });
  }

  onSubmit() {
    console.log(this.registerForm);
  }

  checkBirthDay(a: AbstractControl) {
    const v = a.value;
    console.log(v);
    const birthday: Date = new Date(v);
    const now: Date = new Date();
    console.log(now);
    const day = birthday.getDay();
    console.log(day);
    const month = birthday.getMonth();
    const year = birthday.getFullYear();
    // tslint:disable-next-line:prefer-const
    let ok: boolean;
    if (now.getFullYear() - year >= 18) {
      if (now.getMonth() === month) {
        if (now.getDay() <= day) {
          ok = true;
        }
      } else if (now.getMonth() < month) {
        ok = true;
      }
    } else {
      ok = false;
    }
    // const ok = false;
    console.log(ok ? null : {invalid: true});
    return ok ? null : {invalid: true}  ;
  }
}
