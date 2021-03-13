import { Cliente } from "../cliente";
import { ContoCorrente } from "../conto-corrente";

export class AssociaCcDto {
    cliente: Cliente;
    contoCorrente: ContoCorrente;
}