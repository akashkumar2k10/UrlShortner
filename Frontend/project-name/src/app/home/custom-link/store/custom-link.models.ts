import { UrlType } from '../../link/store/link.models';

export interface CustomLinkState {
  links: CustomLink[];
  loading: boolean;
  error: string;
}

export interface CustomLink {
  id: number;
  longUrl: string;
  shortUrl: string;
  isDisabled: Boolean;
  validTill: string;
}

export interface CustomLinkPayload {
  id?: number;
  longUrl?: string;
  userId?: number;
  isDisabled?: boolean;
  isDeleted?: boolean;
  urlType?: UrlType;
  customUrl?: string;
}
