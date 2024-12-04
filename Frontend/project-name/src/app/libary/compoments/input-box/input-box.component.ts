import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AbstractControl } from '@angular/forms';
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-input-box',
  standalone: true,
  imports: [],
  templateUrl: './input-box.component.html',
  styleUrl: './input-box.component.css',
})
export class InputBoxComponent {
  @Input() placeholder = 'PlaceHolder';
  @Input() _value = '';
  @Input() id = '';
  @Input() isFocus = false;

  @Output() focusOut = new EventEmitter();
  @Output() textChange = new EventEmitter<String>();

  control: AbstractControl;

  constructor(private store: Store) {}

  get value() {
    return this._value;
  }

  set value(val) {
    this._value = val;
    this.propagateChange(this.value);
  }

  propagateChange = (_: any) => {};
  propagteTouch = (_: any) => {};

  registerOnChange(fn) {
    this.propagateChange = fn;
  }

  registerOnTouch(fn) {
    this.propagteTouch(fn);
  }

  onBlur(event) {
    this.propagteTouch(event);
  }

  onChange(event) {
    this.value = event.target.value;
    this.textChange.emit(event.target.value);
  }

  validate(control: AbstractControl) {
    this.control = control;
  }

  get isError() {
    return this.control ? this.control.touched && this.control.invalid : false;
  }
}
