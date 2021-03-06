package org.eclipse.xtext.xbase.typesystem.util;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
@SuppressWarnings("all")
public class TraversalData {
  private final Set<JvmType> _visited = new Function0<Set<JvmType>>() {
    public Set<JvmType> apply() {
      HashSet<JvmType> _newHashSet = CollectionLiterals.<JvmType>newHashSet();
      return _newHashSet;
    }
  }.apply();
  
  public Set<JvmType> getVisited() {
    return this._visited;
  }
  
  private final Map<JvmTypeParameter,JvmTypeReference> _typeParameterMapping = new Function0<Map<JvmTypeParameter,JvmTypeReference>>() {
    public Map<JvmTypeParameter,JvmTypeReference> apply() {
      LinkedHashMap<JvmTypeParameter,JvmTypeReference> _newLinkedHashMap = CollectionLiterals.<JvmTypeParameter, JvmTypeReference>newLinkedHashMap();
      return _newLinkedHashMap;
    }
  }.apply();
  
  public Map<JvmTypeParameter,JvmTypeReference> getTypeParameterMapping() {
    return this._typeParameterMapping;
  }
  
  public TraversalData() {
    super();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_visited== null) ? 0 : _visited.hashCode());
    result = prime * result + ((_typeParameterMapping== null) ? 0 : _typeParameterMapping.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TraversalData other = (TraversalData) obj;
    if (_visited == null) {
      if (other._visited != null)
        return false;
    } else if (!_visited.equals(other._visited))
      return false;
    if (_typeParameterMapping == null) {
      if (other._typeParameterMapping != null)
        return false;
    } else if (!_typeParameterMapping.equals(other._typeParameterMapping))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
