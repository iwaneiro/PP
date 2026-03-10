type graph = (int * int list) list

let reachable_count (g:graph) start_node =
  match g with
  | [] -> 0
  | _ ->
  let get_neighbors node graph =
    try List.assoc node graph
  with Not_found -> []
in
let rec loop queue visited = 
  match queue with
  | [] -> List.length visited
  | h::t -> 
    if List.mem h visited then 
      loop t visited
    else
      let neighbors = get_neighbors h g in
      loop (t @ neighbors) (h :: visited)
  in
  loop [start_node] [];;

  let g = [
(1, [2;3]);
(2, [4]);
(3, [4;5]);
(4, []);
(5, [4])
];;

reachable_count g 3;;
reachable_count g 4;;

let g_cycle = [(1, [2]); (2, [1]); (3, [])];;
reachable_count g_cycle 1;;
reachable_count [] 100;



