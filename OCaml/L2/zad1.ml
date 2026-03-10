let reverse list =
  let rec reverse_iter l acc =
    match l with
    | [] -> acc
    | h::t -> reverse_iter t (h::acc) 
  in
  reverse_iter list [];;


let natrzy list =
  let rec natrzy_iter l (acc10, acc5, acc_rest) =
    match l with
    | [] -> (acc10, acc5, acc_rest)
    | h::t -> 
      if (h mod 10 = 0) then natrzy_iter t (h::acc10, h::acc5, acc_rest)
      else if (h mod 5 = 0) then natrzy_iter t (acc10, h::acc5, acc_rest)
      else natrzy_iter t (acc10, acc5, h::acc_rest)
    in
    let (l10_odw, l5_odw, l_reszta_odw) = natrzy_iter list ([],[],[]) in
    (reverse l10_odw, reverse l5_odw, reverse l_reszta_odw);;


natrzy [];;
natrzy [20;21;25;30;40];;
natrzy [1;2;3;4];;
natrzy[5;15;25];;
natrzy[10;20;30];;
