import { createReducer } from "@ngrx/store";
import { CustomLinkState } from "./custom-link.models";

export const initialState : CustomLinkState = {
    name: "Customer link"
}

export const customLinkReducer = createReducer(
    initialState
)