let rec checkList list value = match list with
| [] -> false
| h::t -> 
  if h = value then true
  else checkList t value;;

let filterLists list value = 
  let rec filterHelper acc = function
  | [] -> List.rev acc
  | h::t ->
    if (checkList h value) then filterHelper (h::acc) t
    else filterHelper acc t
  in
  filterHelper [] list;;


filterLists [[1;2;3];[3;4];[5;6]] 3;;
filterLists [[1;2]; [4;5]; [6]] 3;;
filterLists [[1;3]; [4;5;3]; [3]] 3;;
filterLists [] 3;;

