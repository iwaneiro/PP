let rec removeAll target list =
  match list with 
  | [] -> []
  | h :: t -> 
    if h = target then removeAll target t 
    else h :: removeAll target t
;;

let rec remove_duplicates list elem =
  match list with
  | [] -> []
  | h :: t -> 
    if h = elem then h :: remove_duplicates (removeAll h t) elem
    else h :: remove_duplicates t elem
;;


remove_duplicates [1; 2; 2; 2; 3; 1; 4; 2] 2;;
remove_duplicates [] 2;;
remove_duplicates [1; 1; 1; 1] 1;;
remove_duplicates [1; 2; 3] 2;;
remove_duplicates [5; 1; 5; 1 ;5] 1;;

