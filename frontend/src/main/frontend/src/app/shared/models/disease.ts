import {Symptom} from "./symptom";

export class Disease{

  constructor(public name : string, public general : Array<Symptom>, public specific: Array<Symptom>){}
}
