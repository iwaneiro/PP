let combine list =
  let rec combineHelper acc = function
  |[] -> List.rev acc
  |(a,b,c,d)::t -> 
    let combinedString = (a^b^c^d) in
    combineHelper (combinedString::acc) t
  in
  combineHelper [] list;;


(* lub
let combine list =
  List.map (fun (a,b,c,d) -> a^b^c^d) list;;
   *)

combine [("ala","ma","kot","a"); ("kot","nie","ma","ali")];;
combine [];;
combine [("a","","c","d"); ("","b","","")];;
combine [(" "," "," "," ");("a","","c","d"); ("","b","","")];;