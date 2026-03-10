type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec lpodziel lxs =
  match lxs with
  | LNil -> (LNil, LNil)
  | LCons(x, xf) ->
      match xf() with
      | LNil -> (LCons(x, function () -> LNil), LNil)
      | LCons(y, yf) ->
          (LCons(x, function () -> fst (lpodziel (yf ()))),
           LCons(y, function () -> snd (lpodziel (yf ())))) ;;

(* Pomocnicze do testow *)
let rec toLazyList xs =
  match xs with
  | [] -> LNil
  | h::t -> LCons(h, function () -> toLazyList t);;

  let rec ltake (n, lxs) =
  match (n, lxs) with
  | (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x, xf)) -> x :: ltake(n-1, xf());;

let lista1 = toLazyList [5; 6; 3; 2; 1];;
let (l1, l2) = lpodziel lista1;;
let wynik1 = (ltake(10, l1), ltake(10, l2));;

let (l3, l4) = lpodziel LNil;;
let wynik2 = (ltake(5, l3), ltake(5, l4));;

let lista3 = toLazyList [10; 20; 30; 40];;
let (l5, l6) = lpodziel lista3;;
let wynik3 = (ltake(10, l5), ltake(10, l6));;
