package com.hjj.designmode.structMode.CompositePattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class ItDepartment extends OrganizationComponent {
    public ItDepartment(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent organization) {
        throw new UnsupportedOperationException(this.getName()+"已经是最基本部门，无法增加下属部门");
    }

    @Override
    public OrganizationComponent getChild(String orgName) {
        if(getName().equals(orgName)){
            return this;
        }
        return null;
    }

    @Override
    public int getStaffCount() {
        return 20;
    }
}
