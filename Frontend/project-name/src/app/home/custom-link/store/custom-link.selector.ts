import { createSelector, createFeatureSelector } from '@ngrx/store';
import { CustomLinkState } from './custom-link.models';

export const selectLinkState =
  createFeatureSelector<CustomLinkState>('custom-link');

export const selectAllLinks = createSelector(
  selectLinkState,
  (state: CustomLinkState) => state.links
);

export const selectLinksLoading = createSelector(
  selectLinkState,
  (state: CustomLinkState) => state.loading
);

export const selectLinksError = createSelector(
  selectLinkState,
  (state: CustomLinkState) => state.error
);

export const selectLinkById = (id: number) =>
  createSelector(selectAllLinks, (links) =>
    links.find((link) => link.id === id)
  );
