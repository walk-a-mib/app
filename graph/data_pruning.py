position_attributes = ['lat', 'lon', 'alt']
ga_attributes = ['available', 'accessible', 'indoor', 'floor']

def prune_node(node):
    try:  
        if not type(node) is dict:
            raise Exception

        del node['type']

        props_dict = dict()
        position = dict()
        ga = dict()
        for key in node['properties']:
            prop_value = node['properties'][key][0]['value']
            if key in position_attributes:
                position[key] = prop_value
            elif key in ga_attributes:
                ga[key] = prop_value
            else:
                props_dict[key] = prop_value
        
        del node['properties']
        node.update(props_dict)
        node['position'] = position
        node['ga'] = ga

        return node
    except Exception as e:
        return 'Something went wrong, '

def prune_edge(edge):
    try:
        if not type(edge) is dict:
           raise Exception

        del edge['type']
        del edge['inVLabel']
        del edge['outVLabel']
        del edge['inV']
        del edge['outV']

        props_dict = dict()
        ga = dict()
        for key in edge['properties']:
            prop_value = edge['properties'][key]
            if key in ga_attributes:
                ga[key] = prop_value
            else:
                props_dict[key] = prop_value

        del edge['properties']
        edge.update(props_dict)
        edge['ga'] = ga
        
        return edge
    except Exception:
        return 'Something went wrong'

def prune_nodes(nodes):
    res = list()

    try:
        for node in nodes:
            res.append(prune_node(node))
    except Exception as e:
        return 'Something went wrong'
    return res

def prune_path(path):
    nodes_list = list()
    edges_list = list()
    try:
        for record in path:
            if record['type'] == 'vertex':
                nodes_list.append(prune_node(record))
            else:
                edges_list.append(prune_edge(record))

        return {
            'nodes': nodes_list,
            'edges': edges_list
        }
        
    except Exception as e:
        return 'Something went wrong'

        