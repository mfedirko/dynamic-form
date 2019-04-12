package com.example.exmpl1.presentation.forms;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.*;

import static org.junit.Assert.*;

public class BaseFormTest {
    BaseForm form = new BaseForm() {
        private String test;
        private String test52;
        private Date test666;
        private int fdds;
        private BaseForm test3;
        private String noGetter;

        public void setTest(String test) {
            this.test = test;
        }

        public void setTest52(String test52) {
            this.test52 = test52;
        }

        public void setTest666(Date test666) {
            this.test666 = test666;
        }

        public void setFdds(int fdds) {
            this.fdds = fdds;
        }

        public BaseForm getTest3() {
            return test3;
        }

        public void setTest3(BaseForm test3) {
            this.test3 = test3;
        }

        public String getTest() {
            return "the value2";
        }

        public String getTest52() {
            return test52;
        }

        public Date getTest666() {
            return new Date(105,10,1);
        }

        public int getFdds() {
            return 3535;
        }

        @Override
        public FieldDetail getFieldDetail(String field) {
            if (field == null) return null;
            boolean isReq = requiredFields().contains(field);
            return new FieldDetail(isReq,field,field + " label");
        }


        @Override
        public List<String> requiredFields() {
            return Arrays.asList("test","test52","test3","test666");
        }

        @Override
        public List<String> optionalFields() {
            return  Arrays.asList("fdds");
        }
    };

    @Test
    public void fieldLayout_default() {
        String[][] defaultLayout = form.fieldLayout();
        assertEquals(defaultLayout.length,2);
        assertArrayEquals(defaultLayout[0],new String[]{"test","test52","test3"});
        assertArrayEquals(defaultLayout[1],new String[]{"test666","fdds",null});
    }

    @Test
    public void whenFieldNotExists_throwsException() throws Exception{
        try {
            BaseForm form = new BaseForm() {
                private String test;
                private String test52;
                private Date test666;
                private int fdds;
                private String test3;

                private String someOtherField;

                public String getSomeOtherField() {
                    return someOtherField;
                }

                public void setSomeOtherField(String someOtherField) {
                    this.someOtherField = someOtherField;
                }

                public String getTest() {
                    return test;
                }

                public void setTest(String test) {
                    this.test = test;
                }

                public String getTest52() {
                    return test52;
                }

                public void setTest52(String test52) {
                    this.test52 = test52;
                }

                public int getFdds() {
                    return fdds;
                }

                public void setFdds(int fdds) {
                    this.fdds = fdds;
                }

                public String getTest3() {
                    return test3;
                }

                public void setTest3(String test3) {
                    this.test3 = test3;
                }

                @Override
                public FieldDetail getFieldDetail(String field) {
                    if (field == null) return null;
                    boolean isReq = requiredFields().contains(field);
                    return new FieldDetail(isReq, field, field + " label");
                }


                @Override
                public List<String> requiredFields() {
                    return Arrays.asList("test", "test52", "test3", "test666");
                }

                @Override
                public List<String> optionalFields() {
                    return Arrays.asList("fdds");
                }
            };
        }
        catch (IllegalArgumentException e){
            assertTrue(e.getMessage().contains("test666"));
            return;
        }
        assertTrue(false); // fail if exception not thrown
    }

    @Test
    public void whenAllFieldsExist_initializesForm() throws Exception {
        BaseForm form = new BaseForm() {
            private String abc;
            private String def;
            private Date ghu;
            private int fdds;


            public String getAbc() {
                return abc;
            }

            public void setAbc(String abc) {
                this.abc = abc;
            }

            public String getDef() {
                return def;
            }

            public void setDef(String def) {
                this.def = def;
            }

            public Date getGhu() {
                return ghu;
            }

            public void setGhu(Date ghu) {
                this.ghu = ghu;
            }

            public int getFdds() {
                return fdds;
            }

            public void setFdds(int fdds) {
                this.fdds = fdds;
            }

            @Override
            public FieldDetail getFieldDetail(String field) {
                if (field == null) return null;
                boolean isReq = requiredFields().contains(field);
                return new FieldDetail(isReq, field, field + " label");
            }


            @Override
            public List<String> requiredFields() {
                return Arrays.asList("abc","def","ghu");
            }

            @Override
            public List<String> optionalFields() {
                return Arrays.asList("fdds");
            }
        };


    }

    @Test
    public void allFields(){
        BaseForm form = new BaseForm() {
            private String abc;
            private String def;
            private Date ghu;
            private int fdds;


            public String getAbc() {
                return abc;
            }

            public void setAbc(String abc) {
                this.abc = abc;
            }

            public String getDef() {
                return def;
            }

            public void setDef(String def) {
                this.def = def;
            }

            public Date getGhu() {
                return ghu;
            }

            public void setGhu(Date ghu) {
                this.ghu = ghu;
            }

            public int getFdds() {
                return fdds;
            }

            public void setFdds(int fdds) {
                this.fdds = fdds;
            }

            @Override
            public FieldDetail getFieldDetail(String field) {
                if (field == null) return null;
                boolean isReq = requiredFields().contains(field);
                return new FieldDetail(isReq, field, field + " label");
            }


            @Override
            public List<String> requiredFields() {
                return Arrays.asList("abc","def","ghu");
            }

            @Override
            public List<String> optionalFields() {
                return Arrays.asList("fdds");
            }
        };
        assertEquals(form.allFields(),Arrays.asList("abc","def","ghu","fdds"));

    }

    @Test
    public void allFields_whenNoOptionalFields(){
        BaseForm form = new BaseForm() {
            private String abc;
            private String def;
            private Date ghu;
            private int fdds;


            public String getAbc() {
                return abc;
            }

            public void setAbc(String abc) {
                this.abc = abc;
            }

            public String getDef() {
                return def;
            }

            public void setDef(String def) {
                this.def = def;
            }

            public Date getGhu() {
                return ghu;
            }

            public void setGhu(Date ghu) {
                this.ghu = ghu;
            }

            public int getFdds() {
                return fdds;
            }

            public void setFdds(int fdds) {
                this.fdds = fdds;
            }

            @Override
            public FieldDetail getFieldDetail(String field) {
                if (field == null) return null;
                boolean isReq = requiredFields().contains(field);
                return new FieldDetail(isReq, field, field + " label");
            }


            @Override
            public List<String> requiredFields() {
                return Arrays.asList("abc","def","ghu");
            }

            @Override
            public List<String> optionalFields() {
                return null;
            }
        };
        assertEquals(form.allFields(),Arrays.asList("abc","def","ghu"));
    }


    @Test
    public void allFields_whenNoRequiredFields(){
        BaseForm form = new BaseForm() {
            private String abc;
            private String def;
            private Date ghu;
            private int fdds;


            public String getAbc() {
                return abc;
            }

            public void setAbc(String abc) {
                this.abc = abc;
            }

            public String getDef() {
                return def;
            }

            public void setDef(String def) {
                this.def = def;
            }

            public Date getGhu() {
                return ghu;
            }

            public void setGhu(Date ghu) {
                this.ghu = ghu;
            }

            public int getFdds() {
                return fdds;
            }

            public void setFdds(int fdds) {
                this.fdds = fdds;
            }

            @Override
            public FieldDetail getFieldDetail(String field) {
                if (field == null) return null;
                boolean isReq = requiredFields().contains(field);
                return new FieldDetail(isReq, field, field + " label");
            }


            @Override
            public List<String> optionalFields() {
                return Arrays.asList("abc","def","ghu");
            }

            @Override
            public List<String> requiredFields() {
                return null;
            }
        };
        assertEquals(form.allFields(),Arrays.asList("abc","def","ghu"));
    }

    @Test
    public void getField(){

        Object obj = form.getField("test");
        assertEquals(obj,"the value2");

        Object obj2 = form.getField("test666");
        assertEquals(new Date(105,10,1),obj2);

        Object obj5 = form.getField("test3");
        assertNull(obj5);

        Object obj4 = form.getField("test52");
        assertNull(obj4);

        Object fdds = form.getField("fdds");
        assertEquals(fdds,3535);
    }

    @Test
    public void getField_invalidFieldName(){
        boolean thrown = false;
        try {
            Object obj = form.getField("not present");
        }
        catch (IllegalArgumentException e){
            thrown = true;
        }

        assertTrue(thrown);

        thrown = false;
        try {
            Object obj = form.getField("noGetter");
        }
        catch (IllegalArgumentException e){
            thrown = true;
        }

        assertTrue(thrown);



    }



}