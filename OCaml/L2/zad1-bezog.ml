let rec natrzy list = match list with
| [] -> ([], [], [])
| h::t -> 
  let (l10,l5,lRest) = natrzy t in
  if (h mod 10 = 0) then (h::l10, h::l5, lRest)
  else if (h mod 5 = 0 ) then (l10,h::l5,lRest)
  else (l10,l5,h::lRest);;


  natrzy [20;21;25;30;40];;