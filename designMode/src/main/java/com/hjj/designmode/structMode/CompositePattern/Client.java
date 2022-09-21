package com.hjj.designmode.structMode.CompositePattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class Client {
    public OrganizationComponent constructOrganization(){
        //构建总部
        OrganizationComponent head = new OrganizationComposite("总公司");
        OrganizationComponent headAdmin = new AdminDepartment("总公司行政部");
        OrganizationComponent headIt = new ItDepartment("总公司It部");
        head.add(headAdmin);
        head.add(headIt);

        //构建分公司
        OrganizationComponent branch1 = new OrganizationComposite("天津分公司");
        OrganizationComponent branch1Admin = new AdminDepartment("天津分公司行政部");
        OrganizationComponent branch1It = new ItDepartment("天津分公司It部");
        branch1.add(branch1Admin);
        branch1.add(branch1It);

        head.add(branch1);

        return head;
    }

    public void listOrgInfo() {
        OrganizationComponent org = constructOrganization();
        System.out.println(String.format("%s共有%d名员工",
                org.getName(), org.getStaffCount()));

        OrganizationComponent subOrg = org.getChild("天津分公司行政部");
        System.out.println(String.format("%s共有%d名员工",
                subOrg.getName(), subOrg.getStaffCount()));
    }
}
