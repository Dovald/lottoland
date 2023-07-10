import { JankenDTO } from "./janken-dto";

export class StatsJankenDTO {
    rounds:JankenDTO[];

    constructor() {
        this.rounds = [];
    }
}
