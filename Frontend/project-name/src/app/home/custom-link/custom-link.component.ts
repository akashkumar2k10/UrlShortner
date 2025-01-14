import { Component } from '@angular/core';
import { CustomLink, CustomLinkPayload } from './store/custom-link.models';
import { Store } from '@ngrx/store';
import { AppState } from '../../store/app.reducer';
import * as actions from './store/custom-link.actions';
import { selectAllLinks } from './store/custom-link.selector';
import { UrlType } from '../link/store/link.models';

@Component({
  selector: 'app-custom-link',
  templateUrl: './custom-link.component.html',
  styleUrl: './custom-link.component.css',
})
export class CustomLinkComponent {
  textInput: string = '';
  customUrl: string = '';
  links: CustomLink[] = [];
  newLink: CustomLinkPayload = {
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
    console.log('Form submitted with:', this.customUrl);

    this.store.dispatch(
      actions.addLink(
        this.genratePayloadForAddLink(this.textInput, this.customUrl)
      )
    );
  }
  genratePayloadForAddLink(
    textInput: string,
    customUrl: string
  ): { link: CustomLinkPayload } {
    return {
      link: {
        longUrl: textInput,
        urlType: UrlType.Custom,
        customUrl: customUrl,
      },
    };
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
  genratePayloadForDisable(id: number): { link: CustomLinkPayload } {
    return { link: { id: id, isDisabled: true } };
  }
}
