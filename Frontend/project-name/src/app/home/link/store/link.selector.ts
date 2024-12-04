import { createSelector, createFeatureSelector } from '@ngrx/store';
import { LinkState } from './link.models';

export const selectLinkState = createFeatureSelector<LinkState>('links');

export const selectAllLinks = createSelector(
  selectLinkState,
  (state: LinkState) => state.links
);

export const selectLinksLoading = createSelector(
  selectLinkState,
  (state: LinkState) => state.loading
);

export const selectLinksError = createSelector(
  selectLinkState,
  (state: LinkState) => state.error
);

export const selectLinkById = (id: number) => createSelector(
  selectAllLinks,
  (links) => links.find(link => link.id === id)
);
