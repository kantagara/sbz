import {Remedy} from "./remedy";

export class RemedyPerscription{
  constructor(public diagnosisId : number, remedies: Remedy[]){}
}
