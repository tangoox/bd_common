package sven666.common.bdcommon.utils.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Transient;

/**
 * @author : S_ven
 * @create : 2019-07-10 14:43
 * @describe: TreeNodeInterface
 */
public interface TreeNodeInterface<T extends TreeNodeInterface<T>> {

    @Transient
    @JsonIgnore
    public String getNodePk();

    @Transient
    @JsonIgnore
    public String getNodeParentPk();

    @Transient
    @JsonIgnore
    public List<T> getNodeChildren();


}
