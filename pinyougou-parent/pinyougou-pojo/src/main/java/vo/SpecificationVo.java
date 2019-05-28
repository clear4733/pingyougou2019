package vo;

import cn.itcast.core.pojo.specification.Specification;
import cn.itcast.core.pojo.specification.SpecificationCheck;
import cn.itcast.core.pojo.specification.SpecificationOption;
import cn.itcast.core.pojo.specification.SpecificationOptionCheck;

import java.io.Serializable;
import java.util.List;

/**
 * 包装对象
 * 组合对象
 */
public class SpecificationVo implements Serializable{

    //规格对象 1
    private Specification specification;

    private SpecificationCheck specificationCheck;
    //规格选项结果集对象 多
    private List<SpecificationOption> specificationOptionList;

    private List<SpecificationOptionCheck> specificationOptionCheckList;


    public SpecificationCheck getSpecificationCheck() {
        return specificationCheck;
    }

    public void setSpecificationCheck(SpecificationCheck specificationCheck) {
        this.specificationCheck = specificationCheck;
    }

    public List<SpecificationOptionCheck> getSpecificationOptionCheckList() {
        return specificationOptionCheckList;
    }

    public void setSpecificationOptionCheckList(List<SpecificationOptionCheck> specificationOptionCheckList) {
        this.specificationOptionCheckList = specificationOptionCheckList;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public List<SpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<SpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
