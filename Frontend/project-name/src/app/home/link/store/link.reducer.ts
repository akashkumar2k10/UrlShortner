import { createReducer, on } from '@ngrx/store';
import { LinkState } from './link.models';
import {
  loadLinks,
  loadLinksSuccess,
  loadLinksFailure,
  addLink,
  addLinkSuccess,
  addLinkFailure,
  updateLink,
  updateLinkSuccess,
  updateLinkFailure,
  deleteLink,
  deleteLinkSuccess,
  deleteLinkFailure,
  generateQrCode,
  generateQrCodeFailure,
  generateQrCodeSuccess,
} from './link.actions';

export const initialLinkState: LinkState = {
  links: [],
  loading: false,
  error: '',
};

export const linkReducer = createReducer(
  initialLinkState,

  on(loadLinks, (state) => ({
    ...state,
    loading: true,
  })),
  on(loadLinksSuccess, (state, { links }) => ({
    ...state,
    links: links,
    loading: false,
  })),
  on(loadLinksFailure, (state, { error }) => ({
    ...state,
    error: error,
    loading: false,
  })),
  on(addLink, (state) => ({
    ...state,
    loading: true,
  })),
  on(addLinkSuccess, (state, { link }) => ({
    ...state,
    links: [...state.links, link],
    loading: false,
  })),
  on(addLinkFailure, (state, { error }) => ({
    ...state,
    error: error,
    loading: false,
  })),
  on(updateLink, (state) => ({
    ...state,
    loading: true,
  })),
  on(updateLinkSuccess, (state, { link }) => ({
    ...state,
    links: state.links.map((l) => (l.id === link.id ? link : l)),
    loading: false,
  })),
  on(updateLinkFailure, (state, { error }) => ({
    ...state,
    error: error,
    loading: false,
  })),
  on(deleteLink, (state) => ({
    ...state,
    loading: true,
  })),
  on(deleteLinkSuccess, (state, { id }) => ({
    ...state,
    links: state.links.filter((link) => link.id !== id),
    loading: false,
  })),
  on(deleteLinkFailure, (state, { error }) => ({
    ...state,
    error: error,
    loading: false,
  })),
  on(generateQrCode, (state) => ({
    ...state,
    loading: true,
  })),
  on(generateQrCodeSuccess, (state, { qrCode }) => ({
    ...state,
    qrCode: qrCode,
    loading: false,
  })),
  on(generateQrCodeFailure, (state, { error }) => ({
    ...state,
    error: error,
    loading: false,
  }))
);
