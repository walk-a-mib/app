from collections import deque

def bfs_nearest_nodes(nodes_info, edge_lengths, neighbours_ids, start_node_id, max_distance):
    visited = []
    queue = []

    visited = list()
    visited.append(start_node_id)
    queue.append(start_node_id)

    nearest_nodes = list()
    remaining_distance = dict()
    remaining_distance[start_node_id] = max_distance
    
    while queue:
        current_node = queue.pop(0) 

        for neighbour_id in neighbours_ids[current_node]:
            if neighbour_id not in visited:
                rd = remaining_distance[current_node] - edge_lengths[(current_node, neighbour_id)]
                #return str(remaining_distance[current_node]) + "-" + str(edge_lengths[(current_node, neighbour_id)]) + "=" + str(rd)

                if rd >= 0:
                    remaining_distance[neighbour_id] = rd
                    nearest_nodes.append({'place': nodes_info[neighbour_id], 'distance': rd})
                    visited.append(neighbour_id)
                    queue.append(neighbour_id)         

    return nearest_nodes
    


    


