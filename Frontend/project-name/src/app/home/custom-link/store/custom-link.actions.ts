import { createAction, props } from '@ngrx/store';
import { CustomLink, CustomLinkPayload } from './custom-link.models';

// Load Links
export const loadLinks = createAction('[Custom Link] Load Links');
export const loadLinksSuccess = createAction(
  '[Custom Link] LoadCustom LinkSuccess',
  props<{ links: CustomLink[] }>()
);
export const loadLinksFailure = createAction(
  '[Custom Link] LoadCustom LinkFailure',
  props<{ error: any }>()
);

// Add Link
export const addLink = createAction(
  '[Custom Link] Add Link',
  props<{ link: CustomLinkPayload }>()
);
export const addLinkSuccess = createAction(
  '[Custom Link] Add Custom Link Success',
  props<{ link: CustomLink }>()
);
export const addLinkFailure = createAction(
  '[Custom Link] Add Custom Link Failure',
  props<{ error: any }>()
);

// Update Link
export const updateLink = createAction(
  '[Custom Link] Update Link',
  props<{ link: CustomLinkPayload }>()
);
export const updateLinkSuccess = createAction(
  '[Custom Link] Update Custom Link Success',
  props<{ link: CustomLink }>()
);
export const updateLinkFailure = createAction(
  '[Custom Link] Update Custom Link Failure',
  props<{ error: any }>()
);

// Delete Link
export const deleteLink = createAction(
  '[Custom Link] Delete Link',
  props<{ id: number }>()
);
export const deleteLinkSuccess = createAction(
  '[Custom Link] Delete Custom Link Success',
  props<{ id: number }>()
);
export const deleteLinkFailure = createAction(
  '[Custom Link] Delete Custom Link Failure',
  props<{ error: any }>()
);
