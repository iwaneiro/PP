type 'a tree =
| Empty
| Node of 'a * 'a tree * 'a tree;;

let rec tree_stats t =
  match t with
  | Empty -> (0, 0)
  | Node (_, left, right) ->
    let (n_left, h_left) = tree_stats left in
    let (n_right, h_right) = tree_stats right in
    let total_nodes = 1 +n_left + n_right in
    let total_height = 1 + (if h_left>h_right then h_left else h_right) in
    (total_nodes, total_height);;




tree_stats (Node(1, Node(2, Empty, Empty), Empty));;
tree_stats (Empty);;
let t_right_only = Node(1, Empty, Node(2, Empty, Node(3, Empty, Empty)));;
tree_stats t_right_only;;
let t_balanced = Node(1, 
           Node(2, Node(4, Empty, Empty), Node(5, Empty, Empty)), 
           Node(3, Node(6, Empty, Empty), Node(7, Empty, Empty)));;

tree_stats t_balanced;;