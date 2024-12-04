export interface LinkState {
  links: Link[];
  loading: boolean;
  error: string;
}

export interface Link {
  id: number;
  longUrl: string;
  shortUrl: string;
}

export interface LinkPayload {
  id?: number;
  longUrl: string;
  userId?: number;
}
