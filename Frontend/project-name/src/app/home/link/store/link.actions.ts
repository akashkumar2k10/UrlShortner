import { createAction, props } from '@ngrx/store';
import { Link, LinkPayload } from './link.models';

// Load Links
export const loadLinks = createAction('[Link] Load Links');
export const loadLinksSuccess = createAction(
  '[Link] Load Links Success',
  props<{ links: Link[] }>()
);
export const loadLinksFailure = createAction(
  '[Link] Load Links Failure',
  props<{ error: any }>()
);

// Add Link
export const addLink = createAction(
  '[Link] Add Link',
  props<{ link: LinkPayload }>()
);
export const addLinkSuccess = createAction(
  '[Link] Add Link Success',
  props<{ link: Link }>()
);
export const addLinkFailure = createAction(
  '[Link] Add Link Failure',
  props<{ error: any }>()
);

// Update Link
export const updateLink = createAction(
  '[Link] Update Link',
  props<{ link: LinkPayload }>()
);
export const updateLinkSuccess = createAction(
  '[Link] Update Link Success',
  props<{ link: Link }>()
);
export const updateLinkFailure = createAction(
  '[Link] Update Link Failure',
  props<{ error: any }>()
);

// Delete Link
export const deleteLink = createAction(
  '[Link] Delete Link',
  props<{ id: number }>()
);
export const deleteLinkSuccess = createAction(
  '[Link] Delete Link Success',
  props<{ id: number }>()
);
export const deleteLinkFailure = createAction(
  '[Link] Delete Link Failure',
  props<{ error: any }>()
);

// Generate QR Code
export const generateQrCode = createAction(
  '[Link] Generate QR Code',
  props<{ id: number }>()
);
export const generateQrCodeSuccess = createAction(
  '[Link] Generate QR Code Success',
  props<{ qrCode: string }>()
);
export const generateQrCodeFailure = createAction(
  '[Link] Generate QR Code Failure',
  props<{ error: any }>()
);
