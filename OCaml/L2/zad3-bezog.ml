let rec polacz l1 l2 = match (l1,l2) with
  | ([],l2rest) -> l2rest
  | (l1rest,[]) -> l1rest
  | (h1::t1, h2::t2) -> (h1::h2:: polacz t1 t2);;


polacz [5;4;3;2] [1;2;3;4;5;6];;