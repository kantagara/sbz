import {Remedy} from "./remedy";

export class RemedyPerscription{
  constructor(public diagnosisId : number, public remedies: Remedy[]){}
}
