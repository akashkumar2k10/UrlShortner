import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-link-row-box',
  standalone: true,
  imports: [],
  templateUrl: './link-row-box.component.html',
  styleUrl: './link-row-box.component.css',
})
export class LinkRowBoxComponent {
  @Input() item!: { title: string; description: string };
  @Output() buttonClick = new EventEmitter<void>();

  onButtonClick() {
    this.buttonClick.emit();
  }
}
