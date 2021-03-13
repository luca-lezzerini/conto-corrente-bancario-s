import { Cliente } from "../cliente";
import { ContoPrestito } from "../conto-prestito";

export class AssociaCpDto {
    cliente = new Cliente();
    contoPrestito = new ContoPrestito();
}