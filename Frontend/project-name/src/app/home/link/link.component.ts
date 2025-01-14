import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from '../../store/app.reducer';
import * as actions from './store/link.actions';
import { Link, LinkPayload, UrlType } from './store/link.models';
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

  object = {
    title: 'Box Title',
    description: 'This is the description for the box.',
  };

  handleButtonClick() {
    console.log('Button clicked!');
  }

  constructor(private store: Store<AppState>) {}

  ngOnInit() {
    console.log('Link----> Link ----> link');
    this.store.dispatch(actions.loadLinks());
    this.store.select(selectAllLinks).subscribe((links) => {
      this.links = links;
    });
  }

  onSubmit(): void {
    console.log('Form submitted with:', this.textInput);
    this.store.dispatch(
      actions.addLink(this.genratePayloadForAddLink(this.textInput))
    );
  }
  genratePayloadForAddLink(textInput: string): { link: LinkPayload } {
    return { link: { longUrl: textInput, urlType: UrlType.Default } };
  }

  deleteLink(id: number) {
    console.log('Delete - ', id);
    this.store.dispatch(actions.deleteLink({ id: id }));
  }
  // genratePayloadForDelete(id: number): { link: LinkPayload } {
  //   return { link: { id: id, isDeleted: true } };
  // }
  disableLink(id: number) {
    console.log('Disable - ', id);
    this.store.dispatch(actions.updateLink(this.genratePayloadForDisable(id)));
  }
  genratePayloadForDisable(id: number): { link: LinkPayload } {
    return { link: { id: id, isDisabled: true } };
  }
}
