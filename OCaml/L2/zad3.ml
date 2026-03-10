let reverse list =
  let rec reverse_iter l acc =
    match l with
    | [] -> acc
    | h::t -> reverse_iter t (h::acc) 
  in
  reverse_iter list [];;

let polacz list1 list2 =
  let rec polacz_iter (l1, l2) acc =
    match (l1,l2) with
    | ([],[]) -> acc
    | (h1::t1, h2::t2) -> polacz_iter(t1,t2) (h2::h1::acc)
    | (h1::t1,[]) -> polacz_iter(t1,[]) (h1::acc)
    | ([],h2::t2) -> polacz_iter([],t2)(h2::acc)
  in
  let odwr_lista = polacz_iter (list1,list2) [] in
  reverse odwr_lista;;


  polacz [5;4;3;2] [1;2;3;4;5;6];;
  polacz [1;2;3;4;5;6] [5;4;3;2];;
  polacz [] [1;2;3];;
  polacz [1;2;3] [];;
  polacz ["a";"b"] ["c";"d"];;