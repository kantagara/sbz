import {Symptom} from "./symptom";
import {Remedy} from "./remedy";

export class Diagnosis{

    constructor(public disease: string, public date : string, public jmbg :
      string, public symptoms : Symptom[], public remedy: Remedy[], public id : number){}
}
