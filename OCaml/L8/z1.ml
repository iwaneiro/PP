type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec ltake (n, lxs) =
  match (n, lxs) with
  | (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x, xf)) -> x :: ltake(n-1, xf());;


let lazyFibN n =
  (* a, b - kolejne wyrazy ciągu, counter - licznik indeksu *)
  let rec fib_gen a b counter =
    if counter > n then
      LNil
    else
      LCons (a, function () -> fib_gen b (a + b) (counter + 1))
  in
  fib_gen 0 1 0;;


ltake (10, lazyFibN 4);;
ltake (5, lazyFibN (-2));;
ltake (20, lazyFibN 10);;
