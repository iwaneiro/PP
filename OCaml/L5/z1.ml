type code = Elem of bool | Not | And | Or | Xor

exception EvalError of string

let eval instrs =
  let rec exec instrs stack =
    match (instrs, stack) with
    | ([], [res]) -> res
    | ([], []) -> raise (EvalError "Brak wyniku - stos pusty")
    | ([], _::_::_) -> raise (EvalError "Nieprawidłowe wyrażenie - za dużo elementów na stosie")
    | (Elem b :: rest, _) -> exec rest (b :: stack)
    | (Not :: rest, x :: xs) -> exec rest ((not x) :: xs)
    | (And :: rest, x :: y :: xs) -> exec rest ((x && y) :: xs)
    | (Or  :: rest, x :: y :: xs) -> exec rest ((x || y) :: xs)
    | (Xor :: rest, x :: y :: xs) -> exec rest (((x <> y)) :: xs)
    | (Not :: _, []) -> raise (EvalError "Not - brak argumentu")
    | ((And | Or | Xor) :: _, _) -> raise (EvalError "Operacja binarna - brak argumentów")
  in
  exec instrs [];;



let instr1 = [Elem true; Elem false; And; Not];;
eval instr1;;
let instr2 = [Elem true; Elem false; Elem true; Xor; And];;
eval instr2;;

let instr3 = [Elem true; And];;
eval instr3;;

let instr4 = [Not];;
eval instr4;;

eval [];;

eval [Elem true; Elem true];;
