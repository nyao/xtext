package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
@SuppressWarnings("all")
public class TypeReferenceBucket {
  private final int _id;
  
  public int getId() {
    return this._id;
  }
  
  private final List<JvmTypeReference> _types;
  
  public List<JvmTypeReference> getTypes() {
    return this._types;
  }
  
  public TypeReferenceBucket(final int id, final List<JvmTypeReference> types) {
    super();
    this._id = id;
    this._types = types;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + _id;
    result = prime * result + ((_types== null) ? 0 : _types.hashCode());
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
    TypeReferenceBucket other = (TypeReferenceBucket) obj;
    if (other._id != _id)
      return false;
    if (_types == null) {
      if (other._types != null)
        return false;
    } else if (!_types.equals(other._types))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
