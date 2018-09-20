import {Diagnosis} from "./diagnosis";

export class Patient{

  constructor(public name : string, public surname : string, public jmbg : string, public allergicToRemedy : string[],
              public allergicToIngredient: string[], public diagnosis: Diagnosis[]){}
}
