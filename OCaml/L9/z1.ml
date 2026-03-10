let rec isSorted list = match list with
| [] | [_] -> true
| h1 :: h2 :: t -> if h1 > h2 then false else isSorted (h2::t)
;;


let insert list elem =
  if not (isSorted list) then failwith "Lista wejściowa nie jest posortowana!"
  else 
    let rec insertRec l =
      match l with
      | [] -> [elem]
      | h :: t -> 
        if elem <= h then elem :: h :: t
        else h :: insertRec t
      in insertRec list
;;

insert [1; 3; 5; 7] 4;;
insert ['a'; 'c'] 'b';;       
insert [1; 2; 3] 0;;  
insert [1; 2; 3] 5;;
insert [2; 1; 3] 9;;
