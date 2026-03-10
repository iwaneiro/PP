let reverse list =
  let rec reverseOgon l acc = match l with
  | [] -> acc
  | h::t -> reverseOgon t (h::acc)
in
reverseOgon list [];;

let podziel list num =
  let rec podzielOgon l acc1 acc2 =
    match l with
    | [] -> reverse acc1, reverse acc2
    | h::t ->
      if h>num then podzielOgon t (h::acc1) acc2
      else if h<num then podzielOgon t acc1 (h::acc2)
      else podzielOgon t acc1 acc2
    in
    podzielOgon list [] [];;


podziel [5;4;3;2;1] 3;;
podziel [5;4;3;2;1] 0;;
podziel [5;4;3;2;1] 6;;
podziel [] 2;;
podziel [5;5;5;5] 5;;
