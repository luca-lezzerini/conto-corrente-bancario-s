import { ContoPrestito } from "../conto-prestito";
import { MovimentiContoPrestito } from "../movimenti-cp";

export class MovimentiAssCpDto{

    contoPrestito = new ContoPrestito();
    movimentiContoPrestito: MovimentiContoPrestito[] = [];
}