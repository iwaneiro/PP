type 'a llist = LNil | LCons of 'a * (unit -> 'a llist)

let rec lpolacz l1 l2 =
  match l1 with
  | LNil -> l2 
  | LCons (h1, t1_thunk) ->
      LCons (h1, fun () -> lpolacz l2 (t1_thunk ()));;

let rec ltake n l = 
  if n = 0 then [] 
  else match l with
       | LNil -> []
       | LCons(h, t) -> h :: ltake (n-1) (t());;

let rec from_list list = 
  match list with
  | [] -> LNil
  | h::t -> LCons(h, fun () -> from_list t);;



let rec polacz l1 l2 =
  match l1 with
  | [] -> l2
  | h1 :: t1 -> 
      h1 :: (polacz l2 t1);;



polacz [1;3;5;7;9;11] [2;4;6;8];;

polacz [1;2] [3;4];;

polacz [] [1;2;3];;



let rec ones = LCons(1, fun () -> ones);;
let rec twos = LCons(2, fun () -> twos);;
let mixed = lpolacz ones twos;;
ltake 6 mixed;;

let l_dane = lpolacz (from_list [1;3;5]) (from_list [2;4;6;8]);;
ltake 10 l_dane;;
