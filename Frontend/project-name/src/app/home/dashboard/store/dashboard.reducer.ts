import { createReducer } from "@ngrx/store";
import { DashboardState } from "./dashborad.models";

const initialState : DashboardState={
    name: "Stating Store",
}

export const dashboardReducer = createReducer(initialState)