import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from '../../store/app.reducer';
import {
  loadLinks,
  addLink,
  updateLink,
  deleteLink,
} from './store/link.actions';
import { Link, LinkPayload } from './store/link.models';
import { selectAllLinks } from './store/link.selector';

@Component({
  selector: 'app-link',
  templateUrl: './link.component.html',
  styleUrl: './link.component.css',
})
export class LinkComponent {
  textInput: string = '';
  links: Link[] = [];
  newLink: LinkPayload = {
    longUrl: '',
  };

  constructor(private store: Store<AppState>) {}

  ngOnInit() {
    console.log('Link----> Link ----> link');
    this.store.dispatch(loadLinks());
    this.store.select(selectAllLinks).subscribe((links) => {
      this.links = links;
    });
  }

  onSubmit(): void {
    console.log('Form submitted with:', this.textInput);
    this.store.dispatch(addLink(this.genratePayloadForAddLink(this.textInput)));
  }
  genratePayloadForAddLink(textInput: string): { link: LinkPayload } {
    return { link: { longUrl: textInput } };
  }

  deleteLink(id: number) {
    console.log('Delete - ', id);
  }
}
